import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
  vus: 10,
  duration: '30s',
  ext: {
    loadimpact: {
      // Project: Performance testing with K6
      projectID: 3672127,
      // Test runs with the same name groups test runs together.
      name: 'Test (03/12/2023-11:03:28)'
    }
  }
};

export default function() {
  http.get('http://test.k6.io');
  sleep(1);
}