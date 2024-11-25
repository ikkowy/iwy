import { createApp } from 'vue';
import { createI18n } from 'vue-i18n';
import { createVuetify } from 'vuetify';
import { createPinia } from 'pinia';

import '@mdi/font/css/materialdesignicons.css';
import 'vuetify/styles';

import router from './router';

import App from './App.vue';

import de from './locales/de.json';
import en from './locales/en.json';

const app = createApp(App);

const vuetify = createVuetify({
  theme: {
    defaultTheme: 'light'
  }
});

const pinia = createPinia();

const i18n = createI18n({
  locale: 'en',
  messages: {
    de,
    en
  }
});

app.use(vuetify);
app.use(router);
app.use(pinia);
app.use(i18n);

app.mount('#app');
