import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import InputGroup from 'react-bootstrap/InputGroup';
import { MutableRefObject, useEffect ,useRef, useState } from 'react';
import axios from 'axios';
import CEP from '../../model/CEP';
import Cliente from '../../model/Cliente';
import { usePost } from '../../hooks/useFetch';



export default () => {


    const i_nome = useRef<HTMLInputElement>(null)
    const i_cpf = useRef<HTMLInputElement>(null)
    const i_telefone = useRef<HTMLInputElement>(null)
    const i_telefone2 = useRef<HTMLInputElement>(null)
    const i_telefone3 = useRef<HTMLInputElement>(null)
    const i_cep = useRef<HTMLInputElement>(null)
    const i_rua = useRef<HTMLInputElement>(null)
    const i_numero = useRef<HTMLInputElement>(null)
    const i_bairro = useRef<HTMLInputElement>(null)
    const i_cidade = useRef<HTMLInputElement>(null)
    const i_estado = useRef<HTMLInputElement>(null)


    


    function BuscaCep(){
            axios.get(`https://viacep.com.br/ws/${i_cep.current?.value}/json/`)
                .then(response => {
                    i_rua.current!.value = response.data.logradouro;
                    i_bairro.current!.value = response.data.bairro;
                    i_cidade.current!.value = response.data.localidade;
                    i_estado.current!.value = response.data.uf;
                })
                .catch((error) => {
                    console.log(error)
                })
                .finally(() => {
                    
                })
    }


    function Registrar(){
        let cliente = new Cliente(
            i_nome.current!.value,
            i_cpf.current!.value,
            i_telefone.current!.value,
            i_telefone2.current!.value,
            i_telefone3.current!.value
        )

        
        axios.post("http://localhost:8080/Cliente", cliente).then(res => {
            console.log(res)
        })
        .catch((error) => {
            console.log("teste exception: " + error)

        })

    }
    



    return (
        <>
            <Form className='mt-4' >
                <Row className="mb-3">
                    <Form.Group as={Col} controlId="formGridEmail">
                    <Form.Label>Nome</Form.Label>
                    <Form.Control type="text" placeholder="entra nome" ref={i_nome} />
                    </Form.Group>

                    <Form.Group as={Col} controlId="formGridPassword">
                    <Form.Label>CPF</Form.Label>
                    <Form.Control type="text" placeholder="entra cpf do cliente" ref={i_cpf}/>
                    </Form.Group>
                </Row>

                <Row className="mb-3">
                    <Form.Group as={Col} controlId="formGridEmail">
                    <Form.Label>Telefone 1</Form.Label>
                    <Form.Control type="text" placeholder="entra primeiro telefone" ref={i_telefone}/>
                    </Form.Group>

                    <Form.Group as={Col} controlId="formGridPassword">
                    <Form.Label>telefone 2 (opcional)</Form.Label>
                    <Form.Control type="text" placeholder="entra segundo telefone" ref={i_telefone2}/>
                    </Form.Group>
                </Row>

                <Row className="mb-3">
                    <Form.Group as={Col} controlId="formGridEmail">
                    <Form.Label>telefone 3</Form.Label>
                    <Form.Control type="text" placeholder="entra terceiro telefone" ref={i_telefone3}/>
                    </Form.Group>
                </Row>

                



                <Row className="align-items-center mt-5">

                    <Col xs="2">
                    <Form.Label htmlFor="inlineFormInputGroup" visuallyHidden>
                        CEP
                    </Form.Label>
                    <InputGroup className="mb-2">
                        <InputGroup.Text>CEP</InputGroup.Text>
                        <Form.Control id="inlineFormInputGroup"
                            placeholder="XXXXXX-XX"
                            ref={i_cep}
                            />
                    </InputGroup>
                    </Col>

                    <Col xs="auto">
                    <Button className="mb-2" onClick={BuscaCep}>
                        Buscar
                    </Button>
                    </Col>


                    <Col xs="6">
                    <Form.Label htmlFor="inlineFormInput" visuallyHidden>
                        Rua
                    </Form.Label>
                    <Form.Control
                        className="mb-2"
                        id="inlineFormInput"
                        placeholder="Rua exemplo..."
                        ref={i_rua}
                    />
                    </Col>

                    <Col xs="1">
                    <Form.Label htmlFor="inlineFormInput" visuallyHidden>
                        Número
                    </Form.Label>
                    <Form.Control
                        className="mb-2"
                        id="inlineFormInput"
                        placeholder="Número exemplo..."
                        ref={i_numero}
                    />
                    </Col>

                    <Col xs="auto">
                    <Form.Label htmlFor="inlineFormInput" visuallyHidden>
                        Bairro
                    </Form.Label>
                    <Form.Control
                        className="mb-2"
                        id="inlineFormInput"
                        placeholder="Bairro exemplo..."
                        ref={i_bairro}/>
                    </Col>

                    <Col xs="auto">
                    <Form.Label htmlFor="inlineFormInput" visuallyHidden>
                        Cidade
                    </Form.Label>
                    <Form.Control
                        className="mb-2"
                        id="inlineFormInput"
                        placeholder="Cidade exemplo..."
                        ref={i_cidade}/>
                    </Col>

                    <Col xs="auto">
                    <Form.Label htmlFor="inlineFormInput" visuallyHidden>
                        Estado
                    </Form.Label>
                    <Form.Control
                        className="mb-2"
                        id="inlineFormInput"
                        placeholder="Estado exemplo..."
                        ref={i_estado}/>
                    </Col>
                    

                </Row>

            <Button className='mt-4' variant="primary" onClick={Registrar}>
                Registrar
            </Button>


        </Form>
        </>
    );
}