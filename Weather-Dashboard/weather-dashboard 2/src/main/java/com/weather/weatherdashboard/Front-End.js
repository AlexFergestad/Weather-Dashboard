const apiKey = '0fabcc4be3dfbcc64b13954252176305';
const apiUrl = 'https://api.openweathermap.org/data/2.5/weather?q=omaha&appid=0fabcc4be3dfbcc64b13954252176305';

fetch(`${apiUrl}?apikey=${apiKey}`)
  .then(response => response.json())
  .then(data => {
    // Process and display weather data on your website
    console.log(`Temperature in ${city}: ${temperature}°C`);
  })
  .catch(error => {
    console.error('Error fetching weather data:', error);
  });




