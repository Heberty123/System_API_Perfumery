import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Cadastro from '../../components/cliente/Cadastro';


export default () => {

    return(
        <Container>
            <h1>main</h1>
            <Row>
                <Col>1 of 1</Col>
            </Row>

            <Cadastro/>
        </Container>
        
    );
}