import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import 'bootstrap/dist/css/bootstrap.min.css';

export default () => {

    function teste(){
        console.log("opa fui clicado!");
    }

    return(
        <div>
            <Navbar variant="dark" bg="dark" expand="lg">
                <Container fluid>
                    <Navbar.Brand href="#home">Amélia Revendedora</Navbar.Brand>
                    <Navbar.Toggle aria-controls="navbar-dark-example" />
                    <Navbar.Collapse id="navbar-dark-example">
                    <Nav>
                        <NavDropdown
                        id="nav-dropdown-dark-Cliente"
                        title="Cliente"
                        menuVariant="dark"
                        >
                        <NavDropdown.Item href="#action/3.1" onClick={teste}>Cadastrar</NavDropdown.Item>
                        <NavDropdown.Item href="#action/3.2">
                            Pesquisar
                        </NavDropdown.Item>
                        <NavDropdown.Item href="#action/3.2">
                            Excluir
                        </NavDropdown.Item>
                        <NavDropdown.Item href="#action/3.3">Lista</NavDropdown.Item>
                        <NavDropdown.Divider />
                        <NavDropdown.Item href="#action/3.4">
                            Outras coisas
                        </NavDropdown.Item>
                        </NavDropdown>


                        <NavDropdown
                        id="nav-dropdown-dark-Produtos"
                        title="Produtos"
                        menuVariant="dark"
                        >
                        <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                        <NavDropdown.Item href="#action/3.2">
                            Another action
                        </NavDropdown.Item>
                        <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                        <NavDropdown.Divider />
                        <NavDropdown.Item href="#action/3.4">
                            Separated link
                        </NavDropdown.Item>
                        </NavDropdown>


                        <NavDropdown
                        id="nav-dropdown-dark-Produtos"
                        title="Entregas"
                        menuVariant="dark"
                        >
                        <NavDropdown.Item href="#action/3.1">Acionar entrega</NavDropdown.Item>
                        <NavDropdown.Item href="#action/3.2">
                            editar entrega
                        </NavDropdown.Item>
                        <NavDropdown.Item href="#action/3.3">imprimir</NavDropdown.Item>
                        <NavDropdown.Divider />
                        <NavDropdown.Item href="#action/3.4">
                            Separated link
                        </NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </div>
    )
}