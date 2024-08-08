import React from 'react';
import { Container, Navbar, NavbarBrand } from 'reactstrap';


const Header = () => (
  <Navbar color="light" light expand="md" className="shadow-sm">
    <Container>
      <NavbarBrand href="">Data Visualization Dashboard</NavbarBrand>
    </Container>
  </Navbar>
);

export default Header;