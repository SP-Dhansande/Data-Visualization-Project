import React, { useEffect, useRef } from 'react';
import * as d3 from 'd3';

const DataVisualization = ({ data, filter }) => {
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
      .text('Bar chart');


    if (!data || data.length === 0) {
      svg.append('text')
        .attr('x', 400)
        .attr('y', 250)
        .attr('text-anchor', 'middle')
        .style('font-size', '20px')
        .style('fill', 'gray')
        .text('No data available');
      return;
    }
    let margin, width, height, x, y;

    if (filter === 'city') {
      margin = { top: 20, right: 30, bottom: 40, left: 40 };
      width = +svg.attr('width') - margin.left - margin.right;
      height = +svg.attr('height') - margin.top - margin.bottom;

      x = d3.scaleBand()
        .domain(data.map(d => d.key))
        .range([0, width])
        .padding(0.1);

      y = d3.scaleLinear()
        .domain([0, d3.max(data, d => d.value)])
        .nice()
        .range([height, 0]);

    } else if (filter === 'country') {
      margin = { top: 20, right: 30, bottom: 100, left: 60 };
      width = +svg.attr('width') - margin.left - margin.right;
      height = +svg.attr('height') - margin.top - margin.bottom;

      x = d3.scaleBand()
        .domain(data.map(d => d.key))
        .range([0, width])
        .padding(0.1);

      y = d3.scaleLinear()
        .domain([0, d3.max(data, d => d.value)])
        .nice()
        .range([height, 0]);
    }

    const g = svg.append('g')
      .attr('transform', `translate(${margin.left},${margin.top})`);

    g.selectAll('rect')
      .data(data)
      .enter()
      .append('rect')
      .attr('x', d => filter === 'city' ? x(d.key) : x(d.key))
      .attr('y', d => y(d.value))
      .attr('width', x.bandwidth())
      .attr('height', d => height - y(d.value))
      .attr('fill', 'steelblue');

    g.append('g')
      .attr('class', 'x-axis')
      .attr('transform', `translate(0,${height})`)
      .call(d3.axisBottom(x))
      .selectAll("text")
      .attr("transform", filter === 'country' ? "rotate(-40)" : "")
      .attr("text-anchor", filter === 'country' ? "end" : "middle");

    g.append('g')
      .attr('class', 'y-axis')
      .call(d3.axisLeft(y).ticks(filter === 'country' ? 10 : d3.max(data, d => d.value)).tickFormat(d3.format("d")));
  }, [data, filter]);

  return <svg ref={svgRef}></svg>;
};

export default DataVisualization;


