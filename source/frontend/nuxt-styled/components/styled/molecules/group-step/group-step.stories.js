import GroupStep from './group-step.vue';

export default {
  title: 'Styled/Molecules/[PCFI] ë¨ęł',
  components: GroupStep,
  decorators: [() => ({ template: '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(ěě) Stepper </h2><story /></div>' })],
};

export const Default = () => ({
  components: { GroupStep },
  template: '<GroupStep stepClass="step__list--detail"></GroupStep>'
});
