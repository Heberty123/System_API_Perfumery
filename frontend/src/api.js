import axios from "axios";

const api = axios.create({
    baseURL: 'http://localhost:8080/Cliente/withAddress/2'
});

export default api;