import { useState, useEffect } from 'react'
import { apiGet } from '../services/fetchApi'
import Header from '../components/Header'
import type { Cat } from '../types/Cat'

interface Reservation {
  id: string
  cat: Cat
  reservedAt: string
}

export default function MyReservations() {
  const [list, setList] = useState<Reservation[]>([])

  useEffect(() => {
    apiGet<Reservation[]>('/users/me/reservations')
      .then(setList)
      .catch(console.error)
  }, [])

  return (
    <>
      <Header/>
      <div className="container reservations">
        <h1>Moje rezerwacje</h1>
        {list.length === 0 && <p>Brak rezerwacji</p>}
        {list.map(r => (
          <div key={r.id} className="item">
            <img src={r.cat.imageUrl} alt={r.cat.name} />
            <div className="info">
              <h2>{r.cat.name}</h2>
              <p>Zarezerwowany: {new Date(r.reservedAt).toLocaleString()}</p>
            </div>
          </div>
        ))}
      </div>
    </>
  )
}
