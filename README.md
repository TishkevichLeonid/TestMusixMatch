# TestMusixMatch
Retrofit 2.3
### В данном приложении выводится топ 100 список исполнителей русском чарте. К каждому исполнителю выводится список треков, которые попали в топ 100 список треков в русском чарте.
![Image alt](https://github.com/TishkevichLeonid/TestMusixMatch/raw/master/12.jpg)

#### Первый разпрос chart.artists.get  https://developer.musixmatch.com/documentation/api-reference/artist-chart-get
##### Имеет 4 параметра:
###### country -  A valid country code (default US)
###### page - Define the page number for paginated results
###### page_size - Define the page size for paginated results. Range is 1 to 100.
###### format - Decide the output type (json or xml)
В моем случае помимо api_key используется country = ru, page = 1, page_size = 100

#### Второй запрос chart.tracks.get  https://developer.musixmatch.com/documentation/api-reference/track-chart-get
##### Имеет 4 параметра:
###### country -  A valid country code (default US)
###### page - Define the page number for paginated results
###### page_size - Define the page size for paginated results. Range is 1 to 100.
###### f_has_lyrics - When set, filter only contents with lyrics
В моем случае помимо api_key используется country = ru, page = 1, page_size = 100
##### Полученные данные хранятся в классе Singleton
