import React, { Component } from "react";
import { useFetch } from "./hooks/useFetch.ts";

type Cliente = {
  nome: string;
  cpf: string;
  telefone: string;
  telefone2: string;
  telefone3: string;
}


export default function App() {

  const { data: dados, isFetching } = useFetch<Cliente[]>("http://localhost:8080/Cliente/withAddress/1");
  
  return (
    <ul>
      { isFetching && <p>Carregando...</p> }
      {dados?.map(pro => {
        return (
          <li key={pro.cpf}>
            <strong>{pro.nome}</strong>
            <p>{pro.cpf}</p>
            <p>{pro.telefone}</p>
            <p>{pro.telefone2}</p>
            <p>{pro.telefone3}</p>
          </li>
        )
      })}
    </ul>
  );
}

