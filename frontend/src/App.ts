import React, { Component } from "react";
import { useFetch } from "./hooks/useFetch";

type Cliente = {
  nome: string;
  cpf: string;
  telefone: string;
  telefone2: string;
  telefone3: string;
}


export default function App() {

  const { data, isFetching } = useFetch<Cliente[]>("http://localhost:8080/Cliente/withAddress/1")
  
  return (
    <div>
      { isFetching && <p>Carregando...</p> }
      <h1>{data.telefone}</h1>
    </div>
  );
}

