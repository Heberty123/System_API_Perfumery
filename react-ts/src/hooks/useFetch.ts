import { useEffect, useState } from "react";
import axios, { AxiosRequestConfig } from "axios";

const api = axios.create({
    baseURL: 'http://localhost:8080'
})


/*  API - GET    */

export function useFetch<T = unknown>(url: string, options?: AxiosRequestConfig){
    const [data, setData] = useState<T | null>(null);
    const [isFetching, setIsFetching] = useState(true);

    useEffect(() => {
        api.get(url, options)
            .then(response => {
                console.log(response.data)
                setData(response.data);
            })
            .finally(() => {
                setIsFetching(false);
            })
    }, []);

    return { data, isFetching }
}




/*  API - POST    */

export function usePost<T = unknown>(url: string, options?: AxiosRequestConfig){
    const [data, setData] = useState<T | null>(null);
    const [isFetching, setIsFetching] = useState(true);

    useEffect(() => {
        api.post(url, options)

    }, []);

    return { data, isFetching }
}




