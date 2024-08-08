import React from 'react';
import { FormControl, FormControlLabel, Radio, RadioGroup } from '@mui/material';

const LineChartForm = ({ onSelectData }) => {
  const handleChange = (event) => {
    onSelectData(event.target.value);
  };

  return (
    <FormControl component="fieldset">
      <RadioGroup defaultValue="city" onChange={handleChange}>
        <FormControlLabel value="city" control={<Radio />} label="City Data" />
        <FormControlLabel value="country" control={<Radio />} label="Country Data" />
      </RadioGroup>
    </FormControl>
  );
};

export default LineChartForm;
