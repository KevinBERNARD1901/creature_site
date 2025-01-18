import React from 'react'

function Task({task}) {
  return (
    <>
        <div>
          {task.id};
          <p>{task.title}</p>
          <p>{task.status}</p>
        </div>
    </>
  )
}

export default Task;
