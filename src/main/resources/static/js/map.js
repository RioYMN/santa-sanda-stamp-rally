var map;
var markerDataList = [
    {
        name: 'めんたいパーク',
        adress: "三田市めんたい",
        lat: 34.87477602010673,
        lng: 135.1866705400861,
        icon: 'mentai.jpg'
    },
    {
        name: 'アウトレット',
        adress: "三田市アウトレット",
        lat: 34.85929553623995,
        lng: 135.19173984337237,
        icon: 'outlet.jpg'
    }
];
var infoWindowList = [];
var PinMarkerList = [];
geocoder = new google.maps.Geocoder();
var center = {
    lat: 34.95191839197867, // 緯度
    lng: 135.2184151321297 // 経度
}
var openWindowIdx = null;

function initMap() {

    map = new google.maps.Map(document.getElementById('map'), { // #sampleに地図を埋め込む
        center: center, // 地図の中心を指定
        zoom: 11 // 地図のズームを指定
    });

    for (var idx = 0 ; idx < markerDataList.length ; idx++) {
        let markerData = markerDataList[idx];
        let markerLatLng = new google.maps.LatLng({ lat: markerData.lat, lng: markerData.lng }); // 緯度経度のデータ作成
        PinMarkerList[idx] = new google.maps.Marker({ // マーカーの追加
            position: markerLatLng, // マーカーを立てる位置を指定
            map: map // マーカーを立てる地図を指定
        });
        infoWindowList[idx] = new google.maps.InfoWindow({ // 吹き出しの追加
            content: createContent(idx)
        });

        addClickListener(idx)


    }
}

function addClickListener(idx) {
    PinMarkerList[idx].addListener('click', function () {
        if (openWindowIdx != null) {
            infoWindowList[openWindowIdx].close();
        }
        infoWindowList[idx].open(map, PinMarkerList[idx]);
        openWindowIdx = idx;
    });
}

function createContent(idx){
    let markerData = markerDataList[idx];
    tag = "<div class='spot-map-info'>"
    img = "<img src='" + markerData.icon + "' alt='" + markerData.name +"'>"
    span = "<span>" + (idx + 1)
    title = "<b>" + markerData.name + "</b><br>"
    scription = markerData.adress;
    return tag + img + span + title + scription;
}

initMap();