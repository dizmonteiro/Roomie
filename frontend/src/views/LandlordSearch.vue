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
      queryParam: "",
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

      this.queryParam = "";

      if(this.$route.query.bedrooms)
        this.queryParam += "&rooms=" + this.$route.query.bedrooms

      if(this.$route.query.price)
        this.queryParam += "&price=" + this.$route.query.price

      if(this.$route.query.city)
        this.queryParam += "&city=" + this.$route.query.city


      axios.get(api_url + '/api/houses/?offset=' + this.indiceatual + this.queryParam).then(response => {
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

      this.queryParam = "";

      if(this.$route.query.bedrooms)
        this.queryParam += "&rooms=" + this.$route.query.bedrooms

      if(this.$route.query.price)
        this.queryParam += "&price=" + this.$route.query.price

      if(this.$route.query.city)
        this.queryParam += "&city=" + this.$route.query.city

      axios.get(api_url + '/api/houses/?offset=' + this.indiceatual + this.queryParam).then(response => {
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

      this.queryParam = "";

      if(this.$route.query.bedrooms)
        this.queryParam += "&rooms=" + this.$route.query.bedrooms

      if(this.$route.query.price)
        this.queryParam += "&price=" + this.$route.query.price

      if(this.$route.query.city)
        this.queryParam += "&city=" + this.$route.query.city

      axios.get(api_url + '/api/houses/?offset=' + this.indiceatual + this.queryParam).then(response => {
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

      this.queryParam = "";

      if(this.$route.query.bedrooms)
        this.queryParam += "&rooms=" + this.$route.query.bedrooms

      if(this.$route.query.price)
        this.queryParam += "&price=" + this.$route.query.price

      if(this.$route.query.city)
        this.queryParam += "&city=" + this.$route.query.city

      axios.get(api_url + '/api/houses/?offset=' + this.indiceatual + this.queryParam).then(response => {
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
    this.queryParam = "";

    if(this.$route.query.bedrooms)
      this.queryParam = "?rooms=" + this.$route.query.bedrooms

    if(this.$route.query.bedrooms && this.$route.query.price)
      this.queryParam += "&price=" + this.$route.query.price
    else if(!this.$route.query.bedrooms && this.$route.query.price)
      this.queryParam += "?price=" + this.$route.query.price

    if((this.$route.query.bedrooms || this.$route.query.price) && this.$route.query.city)
      this.queryParam += "&city=" + this.$route.query.city
    else if((!this.$route.query.bedrooms && !this.$route.query.price) && this.$route.query.city)
      this.queryParam += "?city=" + this.$route.query.city

    axios.get(api_url + '/api/houses/total'+this.queryParam).then(response => {
      this.pages = Math.ceil(response.data/9)
      console.log(this.queryParam)

      axios.get(api_url + '/api/houses'+this.queryParam).then(response => {
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