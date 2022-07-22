import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import InputGroup from 'react-bootstrap/InputGroup';
import { useEffect ,useRef } from 'react';






export default () => {


    const i_nome = document.getElementById('i_nome');
    

    function teste(){
        console.log("Você digitou: " + i_nome)
    }


    return (
        <>
            <Form className='mt-4' >
                <Row className="mb-3">
                    <Form.Group as={Col} controlId="formGridEmail">
                    <Form.Label>Nome</Form.Label>
                    <input type="text" placeholder="entra nome" id='i_nome' />
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
                        <Form.Control id="inlineFormInputGroup" placeholder="XXXXXX-XX" />
                    </InputGroup>
                    </Col>

                    <Col xs="auto">
                    <Button type="submit" className="mb-2">
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
                    />
                    </Col>

                    <Col xs="auto">
                    <Form.Label htmlFor="inlineFormInput" visuallyHidden>
                        Cidade
                    </Form.Label>
                    <Form.Control
                        className="mb-2"
                        id="inlineFormInput"
                        placeholder="Cidade exemplo..."
                    />
                    </Col>

                    <Col xs="auto">
                    <Form.Select defaultValue="Choose...">
                        <option>São Paulo</option>
                        <option>Rio de Janeiro</option>
                    </Form.Select>
                    </Col>
                    

                </Row>

            <Button className='mt-4' variant="primary" onClick={teste}>
                Submit
            </Button>


        </Form>
        </>
    );
}