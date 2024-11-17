/**
 * .eslint.js
 *
 * ESLint configuration file.
 */

module.exports = {
  root: true,
  env: {
    node: true
  },
  extends: [
    'vuetify',
    '@vue/eslint-config-typescript',
    './.eslintrc-auto-import.json'
  ],
  rules: {
    'semi': ['error', 'always'],
    'comma-dangle': ['error', 'never'],
    'no-multiple-empty-lines': ['error', { 'max': 2 }],
    'quote-props': 'off',
    'space-before-function-paren': ['error', 'never'],
    'vue/multi-word-component-names': 'off',
    'vue/script-indent': ['error', 2, {
      'baseIndent': 0
    }]
  }
};
