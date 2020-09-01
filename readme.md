#### Atlas API Intermediate Class

Untuk automation intermediate class, kita menggunakan backend sistem yang akan dijalankan di komputer masing - masing. Untuk itu, ada beberapa langkah tambahan untuk menjalankan backend sistem di komputer kita.

Sebelum menjalankan automation, temen - temen jalankan dulu aplikasi backend di komputer kalian masing - masing. Caranya dengan membuka terminal lalu arahkan terminal ke root project dan jalankan command:

`java -jar student-rest-api.jar`

Untuk melihat list endpoint apa saja yang terdapat di backend sistem, temen - temen bisa import postman collection yang sudah disediakan didalam project ini. nama file postman collectionnya `atlas.id.postman_collection.json`. Temen - temen bisa cek untuk cara import postman collection:
 
 `https://learning.postman.com/docs/getting-started/importing-and-exporting-data/#importing-postman-data`
 
 Untuk menjalankan API automation, temen - temen bisa membuka file `ApiJavaAutomationTest.java` lalu pencet tombol play dari sana. Bisa juga dengan command line:
 
 ` ./gradlew clean test`    
 
 
