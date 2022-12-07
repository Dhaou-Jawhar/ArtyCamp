<?php

namespace App\Controller;

use App\Entity\Messagerie;
use App\Form\MessagerieType;
use App\Form\RechercheMType;
use App\Repository\MessagerieRepository;
use Doctrine\Persistence\ManagerRegistry;
use MercurySeries\FlashyBundle\FlashyNotifier;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class MessagerieController extends AbstractController
{
    #[Route('/messagerie', name: 'app_messagerie')]
    public function index(): Response
    {
        return $this->render('messagerie/index.html.twig', [
            'controller_name' => 'MessagerieController',
        ]);
    }

    #[Route('/readm', name: 'read_messagerie')]
    public function readmessagerie(ManagerRegistry $doctrine): Response
    {
        $liste = $doctrine->getRepository(Messagerie::class)
            ->findAll();
        return $this->render('messagerie/readm.html.twig', ['list1' => $liste]);
    }

    #[Route('/addm', name: 'add_messagerie')]
    public function addmessagerie(ManagerRegistry $doctrine, Request $Request , FlashyNotifier $flashy): Response
    {//$entitymanager = $doctrine->getManager();
        $obj = new Messagerie();
        $form = $this->createForm(MessagerieType::class, $obj);
        $form->handleRequest($Request);
        if (($form->isSubmitted()) && ($form->isValid())) {
            $em = $doctrine->getManager();
            $em->persist($obj);
            $em->flush();
            $flashy->success('Message envoyée !!!', 'http://your-awesome-link.com');
            return $this->redirectToRoute('read_messagerie');
        } else {
            return $this->render('messagerie/addm.html.twig', ['f' => $form->createView()]);

        }
    }

    #[Route('/suppm/{id}', name: 'supp_messagerie')]
    public function supprimer($id, ManagerRegistry $doctrine): Response
    {
        $obj = $doctrine->getRepository(Messagerie::class)->find($id);
        $em = $doctrine->getManager();
        $em->remove($obj);
        $em->flush();
        return $this->redirectToRoute('read_messagerie');
    }
    #[Route('/recherchem',name:'rechercher_messagerie')]
    public function rechercher(MessagerieRepository $messagerieRepository, Request $REQUEST){
        $listeR= $messagerieRepository->findAll();
        $form =$this->createForm(RechercheMType::class);
        //$form ->add('recherche', SubmitType:: class);
        $form->handleRequest($REQUEST);//traiter la requete
        if(($form->isSubmitted())){

            $Nomrex=$form['nomrex']->getData();
            $listeR= $messagerieRepository->recherchernomrex($Nomrex);

            return $this->renderForm('messagerie/recherchem.html.twig',['liste'=>$listeR,'f'=>$form]);}
        else{return $this->renderForm('messagerie/recherchem.html.twig',['liste'=>$listeR,'f'=>$form]);

        }


    }
}