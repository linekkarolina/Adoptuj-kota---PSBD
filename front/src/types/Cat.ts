// src/types/Cat.ts
export interface Cat {
  id: string
  name: string
  age: string
  imageUrl: string
  status: 'available' | 'reserved' | 'sold'
}
