import axios from 'axios';

const api = axios.create({
    baseURL: 'https://localhost:8080/Endereco/cep/13311310'
})

export default api;