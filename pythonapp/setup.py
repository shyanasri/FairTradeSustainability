from setuptools import setup
setup(name='Barcode Sustainability Scanner',
      version='1',
      description='Determines whether products have Fairtrade certification',
      url='https://github.com/shyanasri/FairTradeSustainability/tree/master/python',
      author='Runtime Terror',
      license='MIT',
      packages=[],
      install_requires=['numpy','imutils','cv2','pyzbar','requests','csv',],
      zip_safe=False)
