<template>
    <div>
        <div id="map" style="width: 100%; height: 500px"></div>

        <div v-if="selectedSpot" class="info-panel">
            <h2>{{ selectedSpot.title }}</h2>
            <p><strong>주소:</strong> {{ selectedSpot.addr1 }}</p>
            <img
                v-if="selectedSpot.firstimage"
                :src="selectedSpot.firstimage"
                alt="대표 이미지"
                style="max-width: 300px; margin: 10px 0"
            />
            <div v-if="selectedSpot.firstimage2">
                <img
                    :src="selectedSpot.firstimage2"
                    alt="추가 이미지"
                    style="max-width: 300px"
                />
            </div>
        </div>
    </div>
</template>

<script setup>
import { onMounted, ref } from "vue";
import axios from "axios";

const selectedSpot = ref(null);
let map = null;
let markers = [];

const serviceKey =
    "Bk4hfzvI3ihloBb7y0JReGOEktttVbYgQoF%2Fr3wlUjAijt%2FDF8KEBkb46cfNU2EqxVpuQNwhJy4o6Tff6wd2%2Fw%3D%3D";

// 마커를 지도에서 제거
function clearMarkers() {
    markers.forEach((marker) => marker.setMap(null));
    markers = [];
}

// 현재 보이는 화면 내 관광지를 가져오기
async function fetchSpotsInBounds(bounds) {
    const sw = bounds.getSouthWest();
    const ne = bounds.getNorthEast();

    const centerX = (sw.La + ne.La) / 2;
    const centerY = (sw.Ma + ne.Ma) / 2;

    const radius = (calcDistance(sw.Ma, sw.La, ne.Ma, ne.La) / 2) * 1000; // meter 단위

    const url = `https://apis.data.go.kr/B551011/KorService2/locationBasedList2?serviceKey=${serviceKey}&MobileOS=WEB&MobileApp=AppTest&_type=json&mapX=${centerX}&mapY=${centerY}&radius=${radius}`;

    try {
        const res = await axios.get(url);
        return res.data.response.body.items.item || [];
    } catch (e) {
        console.error("API 호출 오류", e);
        return [];
    }
}

// 지도 화면 내 마커 표시
async function updateMarkers() {
    const bounds = map.getBounds();
    clearMarkers();

    const spots = await fetchSpotsInBounds(bounds);

    spots
        .filter((spot) => spot.contenttypeid === "12")
        .forEach((spot) => {
            if (!spot.mapx || !spot.mapy) return;

            const imageSrc =
                "https://cdn-icons-png.flaticon.com/512/684/684908.png";
            const imageSize = new kakao.maps.Size(30, 30);
            const markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

            const marker = new kakao.maps.Marker({
                map,
                position: new kakao.maps.LatLng(spot.mapy, spot.mapx),
                image: markerImage,
            });

            markers.push(marker);

            kakao.maps.event.addListener(marker, "click", () => {
                selectedSpot.value = spot;
            });
        });
}

// 두 좌표 사이 거리 (Haversine formula)
function calcDistance(lat1, lng1, lat2, lng2) {
    const R = 6371; // 지구 반지름 (km)
    const dLat = (lat2 - lat1) * (Math.PI / 180);
    const dLng = (lng2 - lng1) * (Math.PI / 180);
    const a =
        Math.sin(dLat / 2) ** 2 +
        Math.cos(lat1 * (Math.PI / 180)) *
            Math.cos(lat2 * (Math.PI / 180)) *
            Math.sin(dLng / 2) ** 2;
    return R * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
}

onMounted(() => {
    kakao.maps.load(() => {
        const container = document.getElementById("map");
        const options = {
            center: new kakao.maps.LatLng(37.5665, 126.978), // 서울 중심
            level: 7,
        };

        map = new kakao.maps.Map(container, options);

        // 처음 마커 로딩
        updateMarkers();

        // 지도 이동/확대/축소 후 마커 업데이트
        kakao.maps.event.addListener(map, "idle", updateMarkers);
    });
});
</script>

<style scoped>
.info-panel {
    margin-top: 20px;
    padding: 15px;
    background: #f3f3f3;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}
</style>
