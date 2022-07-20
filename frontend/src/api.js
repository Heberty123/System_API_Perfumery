import axios from "axios";

const api = axios.create({
    baseURL: 'http://localhost:8080/Cliente/withAddress/2',
    method: "GET",
    mode: "cors",
});

export default api;