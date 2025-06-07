import { useState, useEffect } from 'react'
import { useParams, useNavigate } from 'react-router-dom'
import Header from '../components/Header'
import { apiGet, apiPost } from '../services/fetchApi'
import type { Cat } from '../types/Cat'

export default function CatDetails() {
  const { id } = useParams<{ id: string }>()
  const nav = useNavigate()

  const [cat, setCat] = useState<Cat | null>(null)

  useEffect(() => {
    apiGet<Cat>(`/cats/${id}`)
      .then(setCat)
      .catch(console.error)
  }, [id])

  if (!cat) return (
    <>
      <Header/>
      <p className="container">Ładowanie / nie znaleziono kota…</p>
    </>
  )

  return (
    <>
      <Header/>
      <div className="container">
        <div className="cat-card">
          <img src={cat.imageUrl} alt={cat.name} className="cat-card__img"/>
          <div className="cat-card__info">
            <h2>{cat.name}</h2>
            <p>Wiek: {cat.age}</p>
            <p>Rasa: {cat.breedName}</p>
            <p>Status: {cat.status}</p>
            <p className="price">{cat.price ?? 0} zł</p>
            <button
              className="reserve-btn"
              onClick={async () => {
                await apiPost(`/cats/${id}/reserve`, { userName: 'Ja', userPhone: '123' })
                nav(`/cats/${id}/success`)
              }}
            >
              Zarezerwuj kota
            </button>
          </div>
        </div>
      </div>
    </>
  )
}
