import axios from 'axios';

import { LocationDTO } from '@/dto/LocationDTO';

const endpoint = 'http://localhost/'; // TODO: No hardcoded endpoint.

export async function getLocations (): Promise<LocationDTO[]> {
  const url = new URL('/api/locations', endpoint).href;
  const response = await axios.get<LocationDTO[]>(url);
  if (response.status !== 200) {
    throw new Error(); // TODO: Improve error handling.
  }
  return response.data;
}

export async function createLocation (name: string, description: string): Promise<LocationDTO> {
  const url = new URL('/api/locations', endpoint).href;
  const response = await axios.post<LocationDTO>(url, {
    name,
    description
  }, {
    headers: {
      'Content-Type': 'application/json'
    }
  });
  if (response.status !== 200) {
    throw new Error(); // TODO: Improve error handling.
  }
  return response.data;
}
