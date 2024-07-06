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

## 2. Criação do `Persistent Volume` e `Persistent Volume Claim` para o Postgres

```bash
kubectl apply -f k8s/pg-pv.yaml
kubectl apply -f k8s/pg-pvc.yaml
```

## 3. Criação do `Secret` do Postgres:

```bash
kubectl apply -f k8s/pg-secret.yaml
```

## 4. Criação do Banco de Dados:

Neste passo serão criados dois artefatos conforme descritos abaixo:

- `Deployment` do Postgres; e
- `Service` do tipo `ClusterIP` para permitir que nossos serviços possam se conectar ao Postgres;

```bash
kubectl apply -f k8s/pg-deployment.yaml
```

## 5. Executar as migrations no Postgres

1. É necessário expor o banco de dados para acesso local:
   Vamos fazer esta exposição utilizando port-foward. Já como nosso cluster k3d está configurado para
   acesso apenas por ingress.

```bash
kubectl port-forward service/postgres-clusterip-srv 5432:5432
```

2. Aplicar scripts de criação da estrutura da persistência.
   <!-- TODO: Automatizar este processo -->
   Utilizando DBeaver ou qualquer outra ferramenta de acesso copie e execute os scripts localizados em `src/main/resources/init-scripts`. É importante executar os scripts na ordem 01, 02... para manter a consistência da estrutuda da base. É importante conectar e criar o banco de dados correspondente: `fiapburger`.

# Cleanup

```bash
# Remover o cluster k3d
k3d cluster delete fiap-sandbox
# remover  o volume criado para o postgres
sudo rm -rf k8s/.volumes/postgres/data -rf
```
