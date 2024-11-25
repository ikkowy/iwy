<template>
  <div class="d-flex flex-column align-center justify-center" style="height: 100%">
    <v-card class="pa-5" variant="elevated" style="min-width: 500px">
      <v-form class="d-flex flex-column">
        <v-text-field
          variant="outlined"
          v-model="form.username"
          label="Username"
          density="compact"
          prepend-inner-icon="mdi-account"
        />
        <v-text-field
          variant="outlined"
          v-model="form.password"
          label="Password"
          type="password"
          density="compact"
          prepend-inner-icon="mdi-key"
        />
        <v-btn variant="flat" color="primary">Login</v-btn>
      </v-form>
    </v-card>
  </div>
</template>

<script setup lang="ts">
import { reactive } from 'vue';

const form = reactive({
  username: '',
  password: ''
});
</script>
