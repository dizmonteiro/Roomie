<template>
  <div>
    <LandlordNavbar />
    <div class="card-pages">
      <div
        class="columns is-centered is-vcentered is-mobile is-tablet is-desktop is-multiline"
      >
        <div class="column is-9-mobile is-9-tablet is-9-desktop">
          
          <SearchOptions />

          <div class="columns">
            <div
              class="column is-one-third-desktop is-one-third-tablet is-one-third-mobile"
            >
              <div v-for="h in column1" :key="h.id" class="block">
                <a :href="h.link1">
                  <div class="card">
                    <div class="card-image">
                      <figure class="image is-4by3">
                        <img
                          :src="h.imgName1"
                          alt="Placeholder image"
                        />
                      </figure>
                    </div>
                    <div class="card-content">
                      <div class="media">
                        <div class="media-left">
                          <figure class="image is-64x64">
                            <img
                              class="is-rounded"
                              :src="h.imgName2"
                              alt="Placeholder image"
                            />
                          </figure>
                        </div>
                        <div class="media-content">
                          <p class="title is-4">{{ h.headline1 }}</p>
                          <p class="subtitle is-6">{{ h.text1 }}</p>
                        </div>
                      </div>

                      <div class="content">
                        {{ h.text2 }}
                      </div>
                    </div>
                  </div>
                </a>
              </div>
            </div>
            <div
              class="column is-one-third-desktop is-one-third-tablet is-one-third-mobile"
            >
              <div v-for="h in column2" :key="h.id" class="block">
                <a :href="h.link1">
                  <div class="card">
                    <div class="card-image">
                      <figure class="image is-4by3">
                        <img
                          :src="h.imgName1"
                          alt="Placeholder image"
                        />
                      </figure>
                    </div>
                    <div class="card-content">
                      <div class="media">
                        <div class="media-left">
                          <figure class="image is-64x64">
                            <img
                              class="is-rounded"
                              :src="h.imgName2"
                              alt="Placeholder image"
                            />
                          </figure>
                        </div>
                        <div class="media-content">
                          <p class="title is-4">{{ h.headline1 }}</p>
                          <p class="subtitle is-6">{{ h.text1 }}</p>
                        </div>
                      </div>

                      <div class="content">
                        {{ h.text2 }}
                      </div>
                    </div>
                  </div>
                </a>
              </div>
            </div>
            <div
              class="column is-one-third-desktop is-one-third-tablet is-one-third-mobile"
            >
              <div v-for="h in column3" :key="h.id" class="block">
                <a :href="h.link1">
                  <div class="card">
                    <div class="card-image">
                      <figure class="image is-4by3">
                        <img
                          :src="h.imgName1"
                          alt="Placeholder image"
                        />
                      </figure>
                    </div>
                    <div class="card-content">
                      <div class="media">
                        <div class="media-left">
                          <figure class="image is-64x64">
                            <img
                              class="is-rounded"
                              :src="h.imgName2"
                              alt="Placeholder image"
                            />
                          </figure>
                        </div>
                        <div class="media-content">
                          <p class="title is-4">{{ h.headline1 }}</p>
                          <p class="subtitle is-6">{{ h.text1 }}</p>
                        </div>
                      </div>

                      <div class="content">
                        {{ h.text2 }}
                      </div>
                    </div>
                  </div>
                </a>
              </div>
            </div>
          </div>
          <div class="block">
            <pagination
              :selectedPage="1"
              :numberOfPages="pages"
              @goBack="pageBack"
              @goForward="pageForward"
              @goStart="pageStart"
              @goEnd="pageEnd"
            >
            </pagination>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Pagination from "@/components/Pagination.vue";
import LandlordNavbar from "@/components/LandlordNavbar.vue";
import SearchOptions from "@/components/SearchOptions.vue";
import axios from 'axios';
import { url as api_url } from "@/assets/scripts/api";

export default {
  name: "LandlordSearch",
  components: { Pagination, LandlordNavbar, SearchOptions },

  data() {
    return {
      allinfo: [],
      copy_allinfo: [
        {
          id: 1,
          headline1: "House Name 1",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 2,
          headline1: "House Name 2",
          text1: "Landlord Name",
          imgName1: "house3.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 3,
          headline1: "House Name 3",
          text1: "Landlord Name",
          imgName1: "house2.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 4,
          headline1: "House Name 4",
          text1: "Landlord Name",
          imgName1: "house6.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 5,
          headline1: "House Name 5",
          text1: "Landlord Name",
          imgName1: "house7.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 6,
          headline1: "House Name 6",
          text1: "Landlord Name",
          imgName1: "house8.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 7,
          headline1: "House Name 7",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 8,
          headline1: "House Name 8",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 9,
          headline1: "House Name 9",
          text1: "Landlord Name",
          imgName1: "house5.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 10,
          headline1: "House Name 10",
          text1: "Landlord Name",
          imgName1: "house8.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 11,
          headline1: "House Name 11",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 12,
          headline1: "House Name 12",
          text1: "Landlord Name",
          imgName1: "house5.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 13,
          headline1: "House Name 13",
          text1: "Landlord Name",
          imgName1: "house8.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 14,
          headline1: "House Name 14",
          text1: "Landlord Name",
          imgName1: "house8.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 15,
          headline1: "House Name 15",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 16,
          headline1: "House Name 16",
          text1: "Landlord Name",
          imgName1: "house5.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 17,
          headline1: "House Name 17",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 18,
          headline1: "House Name 18",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 19,
          headline1: "House Name 19",
          text1: "Landlord Name",
          imgName1: "house8.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 20,
          headline1: "House Name 20",
          text1: "Landlord Name",
          imgName1: "house5.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 21,
          headline1: "House Name 21",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 22,
          headline1: "House Name 22",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 23,
          headline1: "House Name 23",
          text1: "Landlord Name",
          imgName1: "house8.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 24,
          headline1: "House Name 24",
          text1: "Landlord Name",
          imgName1: "house5.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 25,
          headline1: "House Name 25",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 26,
          headline1: "House Name 26",
          text1: "Landlord Name",
          imgName1: "house8.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 27,
          headline1: "House Name 27",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 28,
          headline1: "House Name 28",
          text1: "Landlord Name",
          imgName1: "house5.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 29,
          headline1: "House Name 29",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 30,
          headline1: "House Name 30",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 31,
          headline1: "House Name 31",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 32,
          headline1: "House Name 32",
          text1: "Landlord Name",
          imgName1: "house8.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 33,
          headline1: "House Name 33",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 34,
          headline1: "House Name 34",
          text1: "Landlord Name",
          imgName1: "house5.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 35,
          headline1: "House Name 35",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 36,
          headline1: "House Name 36",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 37,
          headline1: "House Name 37",
          text1: "Landlord Name",
          imgName1: "house8.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 38,
          headline1: "House Name 38",
          text1: "Landlord Name",
          imgName1: "house5.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 39,
          headline1: "House Name 39",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 40,
          headline1: "House Name 40",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 41,
          headline1: "House Name 41",
          text1: "Landlord Name",
          imgName1: "house8.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 42,
          headline1: "House Name 42",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 43,
          headline1: "House Name 43",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 44,
          headline1: "House Name 44",
          text1: "Landlord Name",
          imgName1: "house5.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 45,
          headline1: "House Name 45",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 46,
          headline1: "House Name 46",
          text1: "Landlord Name",
          imgName1: "house8.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 47,
          headline1: "House Name 47",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 48,
          headline1: "House Name 48",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 49,
          headline1: "House Name 49",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 50,
          headline1: "House Name 50",
          text1: "Landlord Name",
          imgName1: "house5.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 51,
          headline1: "House Name 51",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 52,
          headline1: "House Name 52",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 53,
          headline1: "House Name 53",
          text1: "Landlord Name",
          imgName1: "house5.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
        {
          id: 54,
          headline1: "House Name 54",
          text1: "Landlord Name",
          imgName1: "house1.jpg",
          link1: "/",
          imgName2: "face1.svg",
          text2: "House Description Template",
        },
      ],
      column1: [],
      column2: [],
      column3: [],
      indiceatual: 0,
      pages: 1,
      total: 0
    };
  },

  methods: {
    pageBack() {
      this.indiceatual -= 9;
      this.allinfo = [];
      axios.get(api_url + '/api/houses/?offset=' + this.indiceatual).then(response => {
        console.log(response.data)
        for (var entry in response.data){
          if(response.data[entry] != null){
              this.allinfo.push({
                id: response.data[entry].id,
                headline1: response.data[entry].title.substring(0,17),
                text1: response.data[entry].landlord.name,
                imgName1: `${api_url}/api/houses/photos/${response.data[entry].photos[0]}`,
                link1: `/landlord/house/${response.data[entry].id}`,
                imgName2: `${api_url}/api/landlords/${response.data[entry].landlord.id}/avatar`,
                text2: response.data[entry].description.substring(0,30) + "..."
              });
          }
        }
        this.fillColumns();
      }).catch(e => {
        console.log(e)
      }); 
    },

    pageForward() {
      this.indiceatual += 9;
      this.allinfo = [];
      axios.get(api_url + '/api/houses/?offset=' + this.indiceatual).then(response => {
        console.log(response.data)
        for (var entry in response.data){
          if(response.data[entry] != null){
              this.allinfo.push({
                id: response.data[entry].id,
                headline1: response.data[entry].title.substring(0,17),
                text1: response.data[entry].landlord.name,
                imgName1: `${api_url}/api/houses/photos/${response.data[entry].photos[0]}`,
                link1: `/landlord/house/${response.data[entry].id}`,
                imgName2: `${api_url}/api/landlords/${response.data[entry].landlord.id}/avatar`,
                text2: response.data[entry].description.substring(0,30) + "..."
              });
          }
        }
        this.fillColumns();
      }).catch(e => {
        console.log(e)
      }); 
    },

    pageStart() {
      this.indiceatual = 0;
      this.allinfo = [];
      axios.get(api_url + '/api/houses/?offset=' + this.indiceatual).then(response => {
        console.log(response.data)
        for (var entry in response.data){
          if(response.data[entry] != null){
              this.allinfo.push({
                id: response.data[entry].id,
                headline1: response.data[entry].title.substring(0,17),
                text1: response.data[entry].landlord.name,
                imgName1: `${api_url}/api/houses/photos/${response.data[entry].photos[0]}`,
                link1: `/landlord/house/${response.data[entry].id}`,
                imgName2: `${api_url}/api/landlords/${response.data[entry].landlord.id}/avatar`,
                text2: response.data[entry].description.substring(0,30) + "..."
              });
          }
        }
        this.fillColumns();
      }).catch(e => {
        console.log(e)
      }); 
    },

    pageEnd() {
      this.indiceatual = this.total - (this.total - ((this.pages - 1) * 9));
      this.allinfo = [];
      axios.get(api_url + '/api/houses/?offset=' + this.indiceatual).then(response => {
        console.log(response.data)
        for (var entry in response.data){
          if(response.data[entry] != null){
              this.allinfo.push({
                id: response.data[entry].id,
                headline1: response.data[entry].title.substring(0,17),
                text1: response.data[entry].landlord.name,
                imgName1: `${api_url}/api/houses/photos/${response.data[entry].photos[0]}`,
                link1: `/landlord/house/${response.data[entry].id}`,
                imgName2: `${api_url}/api/landlords/${response.data[entry].landlord.id}/avatar`,
                text2: response.data[entry].description.substring(0,30) + "..."
              });
          }
        }
        this.fillColumns();
      }).catch(e => {
        console.log(e)
      }); 
    },

    fillColumns() {
      this.column1 = [];
      this.column2 = [];
      this.column3 = [];
      var i;
      console.log("length " + this.allinfo.length)
      for(i = 0; i < 9; i = i+3){
        if(i < this.allinfo.length)
          this.column1.push(this.allinfo[i]);
        if(i + 1 < this.allinfo.length)
          this.column2.push(this.allinfo[i+1]);
        if(i + 2 < this.allinfo.length)
          this.column3.push(this.allinfo[i+2]);
      }
    },

    onChange(page) {
      console.log(`Getting page ${page}`);
      console.log(page);
    },
  },

  created() {
    axios.get(api_url + '/api/houses/total').then(response => {
      this.pages = Math.ceil(response.data/9)
      var queryParam = "";

      if(this.$route.query.bedrooms)
        queryParam = "?rooms=" + this.$route.query.bedrooms

      if(this.$route.query.bedrooms && this.$route.query.price)
        queryParam += "&price=" + this.$route.query.price
      else if(!this.$route.query.bedrooms && this.$route.query.price)
        queryParam += "?price=" + this.$route.query.price

      if((this.$route.query.bedrooms || this.$route.query.price) && this.$route.query.city)
        queryParam += "&city=" + this.$route.query.location
      else if((!this.$route.query.bedrooms && !this.$route.query.price) && this.$route.query.city)
        queryParam += "?city=" + this.$route.query.city

      console.log(queryParam)

      axios.get(api_url + '/api/houses'+queryParam).then(response => {
        console.log(response.data)
        for (var entry in response.data){
          if(response.data[entry] != null){
              this.allinfo.push({
                id: response.data[entry].id,
                headline1: response.data[entry].title.substring(0,17),
                text1: response.data[entry].landlord.name,
                imgName1: `${api_url}/api/houses/photos/${response.data[entry].photos[0]}`,
                link1: `/landlord/house/${response.data[entry].id}`,
                imgName2: `${api_url}/api/landlords/${response.data[entry].landlord.id}/avatar`,
                text2: response.data[entry].description.substring(0,30) + "..."
              });
          }
        }
        this.fillColumns();
      }).catch(e => {
        console.log(e)
      }); 
    }).catch(e => {
      console.log(e)
    }); 
  },
};
</script>

<style scoped>
#content {
  margin: 3% auto 2% auto;
  width: 100%;
}

.card-pages {
  align-items: center;
  margin-bottom: 5%;
  margin-top: 3%;
}
</style>