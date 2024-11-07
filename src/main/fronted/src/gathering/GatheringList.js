import { useState } from "react";
import axios from "axios";
import App from "../App";

const GatheringList = () => {
    const [data, setData] = useState([]);

    const getGatheringList = () => {
        axios.get("//localhost:8080/busterCall/gathering/gatherings?page=0&size=10&useYn=false").then((res) => {
            setData(res.data.data);
        });
    }

    return (
        <>
        <button onClick={getGatheringList}>모임 목록 호출</button>
            <div>
                {data.map((item) => (
                    <ul key={item.gatheringId}>
                        <li style={{display:"inline-block", marginRight:"20px"}}>{item.name}</li>
                        <li style={{display:"inline-block", marginRight:"20px"}}>{item.contents}</li>
                        <li style={{display:"inline-block", marginRight:"20px"}}>{item.ownerName}</li>
                    </ul>
                ))}
            </div>
        </>
    )
}

export default GatheringList;