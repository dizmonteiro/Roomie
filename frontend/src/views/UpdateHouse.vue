<template>
  <div>
    <LandlordNavbar />
    <div class="columns is-centered is-vcentered is-mobile is-tablet is-desktop is-multiline">
        <div class="column is-four-fifths-mobile is-four-fifths-tablet is-three-quarters-desktop">
            <div class="card" id="form-card">
                <div class="card-content">
                    <p class="title has-text-centered">Update House</p>
                    <FormulateForm v-model="formData" class="columns is-centered" @submit="submitHouse">
                        <div class="column is-full-mobile is-full-tablet is-one-third-desktop">
                            <FormulateInput
                                name="title"
                                label="House Title"
                                type="text"
                                validation="required|max:250,length|min:5,length"
                            />
                            <FormulateInput
                                name="address"
                                label="Address"
                                type="text"
                                validation="required|max:100,length|min:5,length"
                            />
                            <FormulateInput
                                name="rooms"
                                label="Number of Bedrooms"
                                type="number"
                                validation="required|number"
                                min="0"
                                max="10"
                            />
                            <FormulateInput
                                name="availableRooms"
                                label="Available Bedrooms"
                                type="number"
                                validation="required|number"
                                min="0"
                                max="10"
                            />
                            <FormulateInput
                                name="bathRooms"
                                label="Number of Bathrooms"
                                type="number"
                                validation="required|number"
                                min="0"
                                max="10"
                            />
                            <div class="price-range">
                                <FormulateInput
                                    name="minPrice"
                                    label="Min. Price p/ Bedroom"
                                    type="number"
                                    validation="required|number"
                                    min="0"
                                />
                                <div class="spacer"></div>
                                <FormulateInput
                                    name="maxPrice"
                                    label="Max. Price p/ Bedroom"
                                    type="number"
                                    validation="required|number"
                                    min="0"
                                />
                            </div>
                        </div>
                        <div class="column is-full-mobile is-full-tablet is-one-third-desktop">
                            <FormulateInput
                                type="textarea"
                                name="description"
                                label="Description"
                                validation="required"
                                rows="10"
                            />
                            <div id="scroll-area-1">
                                <smooth-scrollbar>
                                    <FormulateInput
                                        type="group"
                                        name="features"
                                        :repeatable="true"
                                        label="Features"
                                        add-label="Add Feature"
                                        validation="required"
                                        v-bind:value="this.formData.features"
                                        disabled
                                    >
                                        <FormulateInput
                                            name="feature"
                                            type="text"
                                            validation="required"
                                            disabled
                                        />
                                    </FormulateInput>
                                </smooth-scrollbar>
                            </div>
                        </div>
                        <div class="column is-full-mobile is-full-tablet is-one-third-desktop">
                            <div id="scroll-area-2">
                                <smooth-scrollbar>
                                    <FormulateInput
                                        type="image"
                                        name="photos"
                                        label="Photos"
                                        help="Select a png, jpg or gif to upload."
                                        validation="required|mime:image/jpeg,image/png,image/gif"
                                        multiple
                                        upload-behavior="delayed"
                                        :uploader="uploadFile"
                                    />
                                </smooth-scrollbar>
                            </div>
                            <FormulateInput
                                type="submit"
                                label="Update House"
                            />
                        </div>
                    </FormulateForm>
                </div>
            </div>
        </div>
    </div>
    <div class="modal" id="modal">
        <div class="modal-background"></div>
          <div class="modal-content">
            <div class="card">
              <div class="card-content is-vcentered">
                <div class="content has-text-centered">
                  <br>
                  <h1>House updated!</h1>  
                  <br>
                  <br>
                  <button type="submit" class="button is-green" v-on:click="goToProfile()">Return to Home</button>
                </div>
              </div>
            </div>
        </div>
        <button class="modal-close is-large" aria-label="close" v-on:click="closeModal()"></button>
    </div>
  </div>
</template>

<script>
import LandlordNavbar from '@/components/LandlordNavbar'
import axios from 'axios';
import { mapGetters, mapState } from 'vuex';
//import store from '@/store';
import { url as api_url } from "@/assets/scripts/api";

function goToProfile() {
    window.location.replace("/landlord");
}

function closeModal() {
    document.getElementById("modal").classList.remove("is-active");
}

export default {
  name: 'UpdateHouse',
  components: {
    LandlordNavbar
  },
  data() {
    return {
        id: this.$route.params.id,
        formData: {
            file: [],
            title: "",
            address: "",
            rooms: "",
            availableRooms: "",
            bathRooms: "",
            minPrice: "",
            maxPrice: "",
            description: "",
            features: ""
        }
    };
  },
  created() {
    axios.get(api_url + '/api/houses/'+this.id).then(response => {
        this.formData = response.data;
        var fs = response.data.features.split(',');
        this.formData.features = [];
        this.formData.file = []
        for (var f in fs){
            this.formData.features.push({feature: fs[f]});
        }
    }).catch(e => {
      console.log(e)
    });  
  },
  computed: {
    ...mapGetters(["getType","getId"]),
    ...mapState({
      type: (state) => `${state.user.type}`,
      user_id: (state) => `${state.user.id}`,
    }),
  },
  methods: {
    closeModal,
    goToProfile,
    /* eslint-disable-next-line */
    async uploadFile (file, progress, error, option) {
      this.formData.file.push(file);
    },
    async submitHouse (data) {

        var bodyFormData = new FormData();
        bodyFormData.append('address', data.address);
        bodyFormData.append('description', data.description);
        bodyFormData.append('minPrice', data.minPrice);
        bodyFormData.append('maxPrice', data.maxPrice);
        bodyFormData.append('bathRooms', data.bathRooms);
        bodyFormData.append('availableRooms', data.availableRooms);
        bodyFormData.append('rooms', data.rooms);
        bodyFormData.append('title', data.title);

        for(var i = 0; i < this.formData.file.length; i++){
            bodyFormData.append('files', this.formData.file[i]);
        }  

        let options = {
            headers: { 
            "Content-Type": "multipart/form-data" 
            }
        }
        await axios.put(api_url + '/api/houses/'+this.$route.params.id, bodyFormData, options).then(() => {
            document.getElementById("modal").classList.add("is-active");
        }).catch(e => {
            alert(e)
        })
    }
  }
}
</script>


<style scoped>
    #form-card {
        min-height: 80vh;
        margin-top: 2%;
        margin-bottom: 5%;
    }

    #scroll-area-1 {
        height: 34vh;
    }

    #scroll-area-2 {
        height: 58vh;
        margin-bottom: 10px;
    }

    .price-range {
        display: flex;
        flex-direction: row;
        justify-content: space-between;
    }

    .spacer {
        width: 5px;
    }
</style>