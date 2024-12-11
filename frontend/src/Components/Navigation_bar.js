import { Link } from "react-router-dom";

function Navigation_bar() {
  return (
    <>
        <nav>
            <ul>
                <li><Link to="/">Horodateur</Link></li>
                <li><Link to="/to_do">To-Do</Link></li>
                <li><Link to="/agenda">Agenda</Link></li>
                <li><Link to="/creatures">Creatures</Link></li>
            </ul>
        </nav>
    </>
  );
}

export default Navigation_bar;

// Mettre de l'animation 3D sur la diapo grâce au format glb.