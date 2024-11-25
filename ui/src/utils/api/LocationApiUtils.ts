import axios from 'axios';

import { LocationDTO } from '@/types/dto/LocationDTO';
import { PageResponse } from '@/types/PageResponse';

const endpoint = 'http://localhost/'; // TODO: No hardcoded endpoint.

export async function getLocations(
  page: number,
  size: number,
  sort?: {key: string, order: string}
): Promise<PageResponse<LocationDTO>> {
  const url = new URL('/api/locations', endpoint).href;
  const params = {
    page,
    size,
    sort: sort ? `${sort.key},${sort.order}` : undefined
  };
  const response = await axios.get(url, { params });
  if (response.status === 200) {
    return {
      content: response.data.content,
      totalElements: response.data.totalElements
    };
  } else {
    throw new Error(); // TODO: Improve error handling.
  }
}

export async function getLocationByUuid(uuid: string): Promise<LocationDTO> {
  const url = new URL(`/api/locations/${uuid}`, endpoint).href;
  const response = await axios.get<LocationDTO>(url);
  if (response.status === 200) {
    return response.data;
  } else {
    throw new Error(); // TODO: Improve error handling.
  }
}

export async function createLocation(name: string, description: string): Promise<LocationDTO> {
  const url = new URL('/api/locations', endpoint).href;
  const response = await axios.post<LocationDTO>(url, { name, description });
  if (response.status === 200) {
    return response.data;
  } else {
    throw new Error(); // TODO: Improve error handling.
  }
}

export async function updateLocation(uuid: string, name: string, description: string): Promise<LocationDTO> {
  const url = new URL('/api/locations', endpoint).href;
  const response = await axios.put<LocationDTO>(url, { uuid, name, description });
  if (response.status === 200) {
    return response.data;
  } else {
    throw new Error(); // TODO: Improve error handling.
  }
}
