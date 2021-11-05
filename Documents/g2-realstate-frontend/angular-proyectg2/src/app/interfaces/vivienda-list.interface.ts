export interface Vivienda {
  titulo: string;
  id: string;
}

export interface ViviendaListResponse {
  count: number;
  results: Vivienda[];
}
