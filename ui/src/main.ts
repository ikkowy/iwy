import { createApp } from 'vue';
import { createI18n } from 'vue-i18n';

import App from './App.vue';

import { registerPlugins } from '@/plugins';

import de from './locales/de.json';
import en from './locales/en.json';

const app = createApp(App);

const i18n = createI18n({
  locale: 'en',
  messages: {
    de,
    en
  }
});

registerPlugins(app);

app.use(i18n);

app.mount('#app');
