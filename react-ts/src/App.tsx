import { useFetch, usePost } from "./hooks/useFetch";

type Cliente = {
  nome: string;
  cpf: string;
  telefone: string;
  telefone2: string;
  telefone3: string;
}

/*
export default function App() {

  
  const { data: dados, isFetching } = useFetch<Cliente>("/Cliente/1");
  
  return (
    <ul>
      <h1>teste</h1>
      { isFetching && <p>Carregando...</p> }
        <h1>Nome: {dados?.nome}</h1>
        <h2>Cpf: {dados?.cpf}</h2>
        <h2>Telefone: {dados?.telefone}</h2>
        <h2>Telefone2: {dados?.telefone2}</h2>
        <h2>Telefone3: {dados?.telefone3}</h2>
    </ul>
  );
}
*/

export default function App() {

  const { data: dados, isFetching } = usePost<Cliente>("/Cliente", {
    data: {
      nome: "testePost",
      cpf: "362.037.388.40",
      telefone: "1354235432",
      telefone2: "323232323",
      telefone3: "997867675",
    }
  });

  return (
    <div>

    </div>
  );

}


  


