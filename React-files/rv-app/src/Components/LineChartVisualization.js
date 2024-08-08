import React, { useEffect, useRef } from 'react';
import * as d3 from 'd3';

const LineChartVisualization = ({ data, isCity }) => {
  const svgRef = useRef();

  useEffect(() => {
    const svg = d3.select(svgRef.current)
      .attr('width', 800)
      .attr('height', 350);

    // Clear previous content
    svg.selectAll('*').remove();

    
    svg.append('text')
      .attr('x', 400)
      .attr('y', 25)
      .attr('text-anchor', 'middle')
      .style('font-size', '20px')
      .style('font-weight', '400')
      .text('Line chart');

    if (data.length === 0) {
      svg.append('text')
        .attr('x', 400)
        .attr('y', 250)
        .attr('text-anchor', 'middle')
        .style('font-size', '20px')
        .style('fill', 'gray')
        .text('No data available');
      return;
    }

    // Set up margins and dimensions
    const margin = { top: 40, right: 30, bottom: 100, left: 40 }; // Increased top margin for heading
    const width = +svg.attr('width') - margin.left - margin.right;
    const height = +svg.attr('height') - margin.top - margin.bottom;

    // Create a group element to contain the chart
    const g = svg.append('g')
      .attr('transform', `translate(${margin.left},${margin.top})`);

    // Define scales for x and y
    const x = isCity
      ? d3.scalePoint()
          .domain(data.map(d => d.key))
          .range([0, width])
      : d3.scaleBand()
          .domain(data.map(d => d.key))
          .range([0, width])
          .padding(0.1);

    const y = d3.scaleLinear()
      .domain(isCity 
        ? [0, d3.max(data, d => d.value)] // City y-axis max
        : [0, d3.max(data, d => d.value) * 1.2] // Country y-axis max
      )
      .nice()
      .range([height, 0]);

    // Line generator
    const line = d3.line()
      .x(d => x(d.key) + (isCity ? 0 : x.bandwidth() / 2))
      .y(d => y(d.value));

    // Append the line path
    g.append('path')
      .datum(data)
      .attr('fill', 'none')
      .attr('stroke', '#1976d2')
      .attr('stroke-width', 2)
      .attr('d', line);

    // Add x-axis
    const xAxis = g.append('g')
      .attr('transform', `translate(0,${height})`)
      .call(d3.axisBottom(x));

    if (!isCity) {
      xAxis.selectAll('text')
        .attr('transform', 'rotate(-45)')
        .attr('text-anchor', 'end')
        .attr('dx', '-0.5em')
        .attr('dy', '0.5em');
    }

    // Add y-axis with integer formatting for city data
    g.append('g')
      .call(d3.axisLeft(y).ticks(isCity ? 10 : 5).tickFormat(isCity ? d3.format("d") : d3.format(".2s"))); // Format y-axis for city as integers

  }, [data, isCity]);

  return <svg ref={svgRef}></svg>;
};

export default LineChartVisualization;
