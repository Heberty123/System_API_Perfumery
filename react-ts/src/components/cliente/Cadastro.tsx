import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import InputGroup from 'react-bootstrap/InputGroup';
import { MutableRefObject, useEffect ,useRef, useState } from 'react';
import axios from 'axios';
import CEP from '../../model/CEP';



export default () => {


    const i_nome = useRef<HTMLInputElement>(null)
    const i_cep = useRef<HTMLInputElement>(null)
    const i_rua = useRef<HTMLInputElement>(null)
    const i_numero = useRef<HTMLInputElement>(null)
    const i_bairro = useRef<HTMLInputElement>(null)
    const i_cidade = useRef<HTMLInputElement>(null)
    const i_estado = useRef<HTMLInputElement>(null)


    useEffect(() => {
        console.log("aconteceu alguma coisa!")
    }, [])
    


    function BuscaCep(){

            axios.get(`http://localhost:8080/Endereco/cep/${i_cep.current?.value}`)
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
    

    function teste(){
        console.log("Você digitou: " + i_nome.current?.value)
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
                    <Form.Control type="text" placeholder="entra cpf do cliente" id='i_cpf'/>
                    </Form.Group>
                </Row>

                <Row className="mb-3">
                    <Form.Group as={Col} controlId="formGridEmail">
                    <Form.Label>Telefone 1</Form.Label>
                    <Form.Control type="text" placeholder="entra primeiro telefone" />
                    </Form.Group>

                    <Form.Group as={Col} controlId="formGridPassword">
                    <Form.Label>telefone 2 (opcional)</Form.Label>
                    <Form.Control type="text" placeholder="entra segundo telefone" />
                    </Form.Group>
                </Row>

                <Row className="mb-3">
                    <Form.Group as={Col} controlId="formGridEmail">
                    <Form.Label>não sei</Form.Label>
                    <Form.Control type="text" placeholder="entra nome" />
                    </Form.Group>

                    <Form.Group as={Col} controlId="formGridPassword">
                    <Form.Label>ainda não </Form.Label>
                    <Form.Control type="text" placeholder="entra cpf do cliente" />
                    </Form.Group>
                </Row>

                



                <Row className="align-items-center mt-5">

                    <Col xs="2">
                    <Form.Label htmlFor="inlineFormInputGroup" visuallyHidden>
                        Username
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


                    <Col xs="auto">
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

            <Button className='mt-4' variant="primary" onClick={teste}>
                Submit
            </Button>


        </Form>
        </>
    );
}