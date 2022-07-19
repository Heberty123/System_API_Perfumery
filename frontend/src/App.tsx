import React, { Component } from "react";
import api from "./api";
import { useFetch } from "./hooks/useFetch";

type Repository = {
  full_name: string;
  description: String;
}

function App() {
  const { data } = useFetch<Repository[]>('https://api.github.com/users/diego3g/repos')

  
    return (
      <ul>
        {data?.map(repo => {
          return (
            <li key={repo.full_name}>
                <strong>{repo.full_name}</strong>
                <p>{repo.description}</p>
            </li>
          )
        })}
      </ul>
    );
  }


export default App;
