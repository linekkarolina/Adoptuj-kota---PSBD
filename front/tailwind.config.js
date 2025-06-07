/** @type {import('tailwindcss').Config} */
export default {
  content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    extend: {
      colors: {
        primary: "#8b78c4",      // Twój fiolet
        "primary-light": "#b39ddb",
        "border-light": "#d2c2e1",
      },
      fontFamily: {
        sans: ["Avenir", "Helvetica", "Arial", "sans-serif"],
        logo: ["Georgia", "serif"],  // możesz podmienić na swój font
      },
      borderRadius: {
        lg: "12px",
        xl: "16px",
      }
    },
  },
  plugins: [],
}
