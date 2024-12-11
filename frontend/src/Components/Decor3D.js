import { Model } from '../Mountain';
import { Canvas } from '@react-three/fiber';
import { OrbitControls } from '@react-three/drei';

function Decor3D() {
  return (
    <>
        <Canvas camera={{ position: [-3,1,1], fov: 30 }}>
            <ambientLight intensity={0.7} />
            <directionalLight
                position={[-5, 5, 5]}
                intensity={1}
                castShadow
                shadow-mapSize-width={1024} 
                shadow-mapSize-height={1024} 
            />
            <Model />
            <OrbitControls enableZoom={true} />
        </Canvas>
        
    </>
  );
}

export default Decor3D;