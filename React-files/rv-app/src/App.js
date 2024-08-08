import React, { useEffect, useState } from 'react';
import { Container, Row, Col } from 'reactstrap';
import Header from './Components/Header';
import FilterForm from './Components/FilterForm';
import DataVisualization from './Components/DataVisualization';
import LineChartForm from './Components/LineChartForm';
import LineChartVisualization from './Components/LineChartVisualization';
import axios from 'axios';

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import './App.css';

const App = () => {
  const [barChartData, setBarChartData] = useState([]); // State for bar chart data
  const [lineChartData, setLineChartData] = useState([]); // State for line chart data
  const [filter, setFilter] = useState('');
  const [selectedData, setSelectedData] = useState('city'); // State for line chart selection

  const handleFilter = (selectedFilter) => {
    setFilter(selectedFilter);
  };
// Effect for fetching bar chart data
  useEffect(() => {
    let apiEndpoint = '';

    switch (filter) {
      case 'city':
        apiEndpoint = 'http://localhost:8080/citycounts';
        break;
      case 'country':
        apiEndpoint = 'http://localhost:8080/countrycounts';
        break;
      default:
        toast.info(' Please select a filter.');
        setBarChartData([]); // Clear bar chart data if no valid filter is selected
        return; // Exit the effect to avoid unnecessary API calls
    }

    if (apiEndpoint) {
      axios.get(apiEndpoint)
        .then(response => {
          const counts = response.data;
          if (Object.keys(counts).length === 0) {
            toast.error('No data found for the selected filter!');
            setBarChartData([]); // Clear bar chart data
          } else {
            const formattedData = Object.entries(counts).map(([key, value]) => ({
              key,
              value
            }));
            setBarChartData(formattedData);
          }
        })
        .catch(error => {
          console.error('Error fetching data:', error);
          toast.error('Error fetching data from the server!'); // Show toast for error
          setBarChartData([]); // Set bar chart data to empty array on error
        });
    } else {
      setBarChartData([]); // Clear bar chart data if no valid filter is selected
    }
  }, [filter]);

  // Effect for fetching line chart data
  useEffect(() => {
    const apiEndpoint1 = selectedData === 'city'
      ? 'http://localhost:8080/citycounts'
      : 'http://localhost:8080/countrycounts';

    const fetchData = async () => {
      try {
        const response = await axios.get(apiEndpoint1);
        const counts = response.data;
        const formattedData = Object.entries(counts).map(([key, value]) => ({
          key,
          value
        }));
        setLineChartData(formattedData); // Set line chart data
      } catch (error) {
        console.error('Error fetching line chart data:', error);
        setLineChartData([]); // Set line chart data to empty array on error
      }
    };

    fetchData();
  }, [selectedData]);

  return (
    <div>
      <Header />
      <Container>
        <Row>
          <Col md={3}>
            <FilterForm onFilter={handleFilter} />
          </Col>
          <Col md={9}>
            <DataVisualization data={barChartData} filter={filter} /> 
          </Col>
        </Row>
        </Container>
        <Container>
        <Row>
          <Col md={3}>
            <LineChartForm onSelectData={setSelectedData} /> 
          </Col>
          <Col md={9}>
            <LineChartVisualization data={lineChartData} /> 
          </Col>
        </Row>
      </Container>
      <ToastContainer /> 
    </div>
  );
};

export default App;





