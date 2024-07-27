# Ambiente de Desenvolvimento Local:

## Pré-Requisitos:

- Docker: https://www.docker.com/
- K3D: https://k3d.io/v5.6.3/#installation

## 1. Criação do Cluster K8S (Localmente)

> Navegar pelo terminal até a raiz do projeto antes de executar os seguintes comandos. Neste exemplo estamos utilizando uma máquina Windows com WSL2

```bash
# Criar um cluster kubernetes com k3d
k3d cluster create --api-port 6550 -p "7777:80@loadbalancer" fiap-sandbox --agents 2 --volume $(pwd)/k8s/.volumes:/var/lib/rancher/k3s/storage@all
```

## 2. Criação do `Persistent Volume`

> IMPORTANTE:
>
> Este PV está configurado para funcionar com o K3D. Caso queria executar num outro cluster pode ser necessário a chave `spec.hostPath.path` (linha 19) para um caminho dentro do host.

```bash
kubectl apply -f k8s/pg-pv.yaml
```

## 3. `Persistent Volume Claim` para o Postgres

```bash
kubectl apply -f k8s/pg-pvc.yaml
```

## 4. Criação do `Secret` do Postgres:

```bash
kubectl apply -f k8s/pg-secret.yaml
```

## 5. Criação do Banco de Dados:

Neste passo serão criados dois artefatos conforme descritos abaixo:

- `Deployment` do Postgres; e
- `Service` do tipo `ClusterIP` para permitir que nossos serviços possam se conectar ao Postgres;

```bash
kubectl apply -f k8s/pg-deployment.yaml
```

## 6. Executar as migrations no Postgres

1. É necessário expor o banco de dados para acesso local. Vamos fazer esta exposição utilizando port-foward, pois o cluster k8s criado com k3d está configurado para acesso por ingress na porta 7777. Para acessar um nodeport seria necessário realizar configurações adicionais.

```bash
kubectl port-forward service/postgres-clusterip-srv 5432:5432
```

2. Obter senha de admim do banco de dados postgres

```bash
 kubectl get secret pgsecrets --template={{.data.POSTGRES_PASSWORD}} | base64 -d
```

3. Conectar à base de dados utilizando alguma ferramenta de preferência, DBeaver, Azure Data Studio.

4. Utilizando DBeaver ou qualquer outra ferramenta de acesso copie e execute os scripts localizados em `./src/main/resources/init-scripts`.

## 7. Implantar a aplicação Java Spring:

Neste passo alguns artefatos serão criados:

- `Secret` contendo as credenciais de conexão com o banco de dados, em ambiente produtivo esses secrets não seriam expostos no gerenciamento de versão;
- `Deployment` para gerenciar a aplicação;
- `HorizontalPodAutoscaler` para realizar autoscaling da aplicação;
- `Service` tipo `ClusterIP` para expor a aplicação dentro do cluster; e
- `Ingress` para expor a aplicação na porta de entrada do cluster;

```bash
kubectl apply -f k8s/app-deployment.yaml
```

# 8. Agora é possível acessar a aplicação para testes

Por exemplo no processo de autenticação:

```bash
curl --location 'http://localhost:7777/fiap-burger/api/v1/auth' \
--header 'Content-Type: application/json' \
--data '{
    "username": "admin",
    "password": "123456"
}'
```

# Desfazimento e Limpeza do Ambiente

```bash
# Remover o cluster k3d
k3d cluster delete fiap-sandbox
# remover  o volume criado para o postgres
sudo rm -rf k8s/.volumes/postgres/data -rf
```

# Sequencia de aplicação dos manifestos de K8S:

1. k8s/pg-pv.yaml
2. k8s/pg-pvc.yaml
3. k8s/pg-secret.yaml
4. k8s/pg-deployment.yaml
5. k8s/app-deployment.yaml

[Voltar ao Início](../README.md)
