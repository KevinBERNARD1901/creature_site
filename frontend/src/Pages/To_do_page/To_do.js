import { useEffect, useState } from 'react'
import Task from './Task';

function To_do() {
    const base_url_api = 'http://localhost:8080';
    const [tasks, setTasks] = useState([]);

    const getTasks = async function() {
        try {
            const response = await fetch(`${base_url_api}/tasks`)
            const data = await response.json();
            setTasks(data);
        } catch(err) {
            console.log(err)
        }
    };

    const addTask = async function(body) {
        try {
            const response = await fetch (`${base_url_api}/tasks`, {
                method: 'POST',
                body: JSON.stringify({
                    body: body,
                }),
                headers: {
                    'Content-type': 'application/json; charset=UTF-8',
                }
            });
            const data = await response.json();
            console.log(data);
            return data;
        } catch(err) {
            console.log(err)
        }
    };

    useEffect(() => {
        getTasks();
    }, []);

    return (
        <>
            <ul>
                {tasks.map(task => (
                    <Task key={task.id} task={task} />
                ))}
            </ul>
            <button onClick={() => {
                
            }}/>
        </>
    );
};

export default To_do;