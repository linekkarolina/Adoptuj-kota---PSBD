import { useState, useRef, useEffect } from 'react'
import { Link } from 'react-router-dom'

export default function Header() {
  const [open, setOpen] = useState(false)
  const dropdownRef = useRef<HTMLDivElement>(null)

  // Zamykanie menu przy kliknięciu poza
  useEffect(() => {
    const onClickOutside = (e: MouseEvent) => {
      if (
        dropdownRef.current &&
        !dropdownRef.current.contains(e.target as Node)
      ) {
        setOpen(false)
      }
    }
    document.addEventListener('mousedown', onClickOutside)
    return () => document.removeEventListener('mousedown', onClickOutside)
  }, [])

  return (
    <header className="header container">
      <Link to="/" className="header__logo">Adoptuj kota</Link>

      <div className="header__search">
        <input type="text" placeholder="Szukaj kota..." />
      </div>

      <div className="header__menu">
        <button
          aria-label="Otwórz menu"
          onClick={() => setOpen(o => !o)}
        >
          Menu
        </button>

        <div className="header__dropdown" ref={dropdownRef}>
          <button
            aria-label="Profil"
            onClick={() => setOpen(o => !o)}
          >
          </button>

          {open && (
            <div className="header__dropdown-content">
              <Link to="/">Przeglądaj koty</Link>
              <Link to="/my-reservations">Moje rezerwacje</Link>
              <Link to="/">Ustawienia</Link>
            </div>
          )}
        </div>
      </div>
    </header>
  )
}
