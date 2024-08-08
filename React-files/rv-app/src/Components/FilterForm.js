import React, { useState } from 'react';
import { Form, FormGroup, Label, Input, Button, Col } from 'reactstrap';

const FilterForm = ({ onFilter }) => {
    const [filter, setFilter] = useState('');

    const handleChange = (e) => {
        setFilter(e.target.value);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        onFilter(filter);
    };

    return (
        <Form onSubmit={handleSubmit}>
            <FormGroup >
                <Label for="filter" sm={2}>Filter</Label>
                <Col sm={10}>
                    <Input type="select" name="filter" id="filter" onChange={handleChange}>
                        <option value="">Select Filter</option>
                        <option value="city">City</option>
                        <option value="country">Country</option>

                    </Input>
                </Col>
            </FormGroup>
            <FormGroup row>
                <Col sm={{ size: 10, offset: 2 }}>
                    <Button color="primary" type="submit" disabled={filter === ''}>Apply Filter</Button>
                </Col>
            </FormGroup>

        </Form>
    );
};

export default FilterForm;