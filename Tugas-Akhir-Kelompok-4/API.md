## Application Programming Interface

### List
* [/lab/kebutuhan/perencanaan](#apicheckstatus)
* [/lab/pemeriksaan/permintaan](#apicheckstatus)

#### URL : `/lab/kebutuhan/perencanaan`
#### Method : `GET`

### Response
```json
{
        "id": 1,
	"updateTime":"2019-05-28",
	"total": 2,
	"status": 1,
        "labsupplies": {
	    "id": 2,
	    "kindOf":3,
	    "name":"metformin",
            "total": 5,
	    "description":"metformin Kaplet 500 mg"
         }
}
```

#### URL : `/lab/pemeriksaan/permintaan`
#### Method : `POST`

### Response
```json
{
        "id": 1,
	"tanggal_pengajuan":"2019-01-28",
	"status": 1,
	"id_pasien":2,
	"id_jenis":1,
	"id_jadwal":3,
	"hasil":"menyedihkan",
	"tanggal_pemeriksaan":"2019-01-20"
}
```
