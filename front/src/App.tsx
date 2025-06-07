import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom'
import CatDetails from './pages/CatDetails'
import ReservationSuccess from './pages/ReservationSuccess'
import MyReservations from './pages/MyReservations'

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Navigate to="/cats/123" replace />} />
        <Route path="/cats/:id" element={<CatDetails />} />
        <Route path="/cats/:id/success" element={<ReservationSuccess />} />
        <Route path="/my-reservations" element={<MyReservations />} />
        <Route path="*" element={<Navigate to="/" replace />} />
      </Routes>
    </BrowserRouter>
  )
}
