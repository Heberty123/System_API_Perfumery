import { useFetch, usePost } from "./hooks/useFetch";
import Cliente from "./model/Cliente"
/*

export default function App() {

  
  const { data: dados, isFetching } = useFetch<Cliente>("/Cliente/1");

  let cliente = new Cliente("dataEstaCaindoCerto!", "47928197847", "3252523545", "931546646", "244735646");

  usePost<Cliente>("/Cliente", {
    data: cliente
  });
  
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




let cliente = new Cliente("Vanderléria santos melaré fernandes", "42597142876", "3252523545", "931546646", "244735646");
let cliente1 = new Cliente("Vagner ferreira mello", "30296415898", "3252523545", "931546646", "244735646");



  const { data, isFetching } = useFetch<Cliente[]>("/Cliente");


return (
  <div>
    <h1>
    lista de clientes
    </h1>
    <ul>
      {data?.map(p => {
        return (
          <div key={p.cpf}>
            <h2>{p.nome}</h2>
            <li>{p.cpf}</li>
            <li>{p.telefone}</li>
            <li>{p.telefone2}</li>
            <li>{p.telefone3}</li>
          </div>
        )
      })}
    </ul>
  </div>
  
);
  
}

