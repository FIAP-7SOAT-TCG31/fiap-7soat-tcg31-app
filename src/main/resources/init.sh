#!/bin/bash
docker build -t postgres .
docker run -d --name postgres-container -p 5432:5432 postgres


