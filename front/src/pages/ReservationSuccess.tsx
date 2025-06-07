import { useParams, Link } from 'react-router-dom'
import Header from '../components/Header'

export default function ReservationSuccess() {
  const { id } = useParams<{ id: string }>()

  return (
    <>
      <Header/>
      <div className="container success">
        <h1>Rezerwacja potwierdzona!</h1>
        <p>Kot <strong>{id}</strong> czeka na Ciebie.</p>
        <Link to="/my-reservations">Moje rezerwacje</Link>
      </div>
    </>
  )
}
